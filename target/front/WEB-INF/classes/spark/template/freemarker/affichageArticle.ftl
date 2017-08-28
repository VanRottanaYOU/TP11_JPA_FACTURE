<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage de l'article créé</title>
        <link type="text/css" rel="stylesheet" href="./css/style.css"  />
    </head>
    <body>
    	<p>Affichage de l'article créé</p>
        <p>Libellé : ${article.nom }</p>
        <p>Prix : ${article.prix }</p>
        <p>Description : ${article.description.getDescription()}</p>      
    </body>
</html>