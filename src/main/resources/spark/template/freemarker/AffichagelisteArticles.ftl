<html>
    <head>
        <meta charset="utf-8" />
        <title>Recherche utilisateur</title>
        <link type="text/css" rel="stylesheet" href="./css/style.css"  />
    </head>
    <body>

        <div>
			<table border CELLSPACING=0>
			<tr>
		      <th>IdArticle</th>
		      <th>Nom</th>
		      <th>Prix</th>
		      <th>Description</th>
		    </tr>
				<#list monSetArticle as article>	
					<tr ALIGN=center >	
						<td>${article.getIdArticle()}</td>
						<td>${article.nom}</td>
						<td>${article.prix}</td>
						<td>${article.description.getDescription()}</td>
				</#list>
			</table>
        </div>
    </body>
</html>