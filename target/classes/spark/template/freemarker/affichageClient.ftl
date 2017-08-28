<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un utilisateur</title>
        <link type="text/css" rel="stylesheet" href="./css/style.css"  />
    </head>
    <body>
    	<p>**********Affichage du client ajouté*************</p>
        <p>Nom : ${client.nom }</p>
        <p>Prénom : ${client.prenom }</p>
        <p>Age: ${client.age }</p>
        <p>AdresseLivraison : ${client.adresse.getAdresseLivraison() }</p>
        <p>AdresseFacturation: ${client.adresse.getAdresseFacturation()}</p>
        <p>Numéro de téléphone : ${client.telephone }</p>
        <p>Email : ${client.email }</p>
    </body>
</html>