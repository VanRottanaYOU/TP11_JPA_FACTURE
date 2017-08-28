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
		      <th>IdClient</th>
		      <th>Nom</th>
		      <th>Prénom</th>
		      <th>Age</th>
		      <th>Adresse de livraison</th>
		      <th>Adresse de facturation</th>
		      <th>Email</th>
		    </tr>
				<#list listeClients as client>	
					<tr ALIGN=center >	
						<td>${client.IdClient}</td>
						<td>${client.nom}</td>
						<td>${client.prenom}</td>
						<td>${client.age}</td>
						<td>${client.adresseLivraion}</td>
						<td>${client.adresseFacturation}</td>
						<td>${client.email}</td>
					</tr>
				</#list>
			</table>
        </div>
    </body>
</html>