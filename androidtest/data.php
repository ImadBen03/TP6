<?php
try {
    $pdo_options[PDO::ATTR_ERRMODE] = PDO::ERRMODE_EXCEPTION;
    $bdd = new PDO('mysql:host=localhost:3307;dbname=dbtp7','root','',$pdo_options);
    $sql='SELECT * FROM etudiant;';
    $response = $bdd->query($sql);
    $output = $response->fetchAll(PDO::FETCH_ASSOC);
} catch (Exception $e){
    die('Erreur : ' . $e->getMessage());
}

echo(json_encode($output));