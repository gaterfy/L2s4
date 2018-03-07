<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<?php
		require_once('connection.php');
		$dossard = $_POST['dossard'];
		$time = $_POST['usr_time'];
		$query = "INSERT INTO etape(dossard, arrivee) VALUES(:dossard, :time)";

		try {
			$stmt = $connection->prepare($query);
			$stmt->bindValue(':dossard', $dossard);
			$stmt->bindValue(':time', $time);
			$stmt->execute();
		} catch (PDOException $e) {
			echo $e->getMessage();
		}
		?>
	</body>
</html>
