<!DOCTYPE html>
<html>
    <head>
        <title>Consultar</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css" href="consultar.css" />
    </head>
    <body>
        <h3>Consultar información sobre un usuario </h3>
        <form action="index.php" method="post">
            <label for="numero">Número de usuario:</label>
            <input type='text' name = 'numero' maxlength="10" size="10" id="numero">
            <input type="submit" name="op" value="Buscar" />
        </form>
        <?php
        $buscar = filter_input(INPUT_POST, "op");
        if ($buscar == "Buscar") {
            $usuario = filter_input(INPUT_POST, "numero");
            /* Crear un novo obxecto de conexión */
            $conexion = new mysqli("localhost", "consulta", "abc", "direccions");
            if (mysqli_connect_errno()) {
                echo '<p class="erro">Erro. Fallo na conexión co servidor. </p>'; 
                exit();
            }
            /* Para evitar problemas con caracteres acentuados ou ñ */
            $acentos=$conexion->query("SET NAMES 'utf8'");
            /* Crear consulta para saber se o usuario existe na táboa correos */
            $consulta = "SELECT nome, email FROM correos WHERE id='" . $usuario . "';";
            $resultado = $conexion->query($consulta);
            $afectados = $resultado->num_rows;
            if ($afectados == 0) {
                echo'<p class="erro">O usuario número '.$usuario.' non existe.</p>';
            } else {
                $fila=$resultado->fetch_array();
                echo '<h3>Información sobre o usuario '.$usuario.' </h3>';
                echo '<table>';
                echo '<tr><th>Nome</th><td>'.$fila["nome"].'</td></tr>';
                echo '<tr><th>Dirección de correo</th><td>'.$fila["email"].'</td></tr>';
                echo '</table>';
            }
            $resultado->free();
            $conexion->close();
        }
        ?>
    </body>
</html>
