<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des factures facture</title>
        <link type="text/css" rel="stylesheet" href="./css/style.css"  />
    </head>
    <body>

        <div>
			<table border CELLSPACING=0>
			<tr>
		      <th>IdFacture</th>
		      <th>Nom</th>
		      <th>Prénom</th>
		      <th>Montant</th>
		    </tr>
				<#list monSetFacture as facture>	
					<tr ALIGN=center >	
						<td>${facture.getId()}</td>
						<td>${facture.getClient().getNom()}</td>
						<td>${facture.getClient().getPrenom()}</td>
						<td>${facture.getTotalTTC()}</td>
					</tr>
				</#list>
			</table>
        </div>
    </body>
</html>