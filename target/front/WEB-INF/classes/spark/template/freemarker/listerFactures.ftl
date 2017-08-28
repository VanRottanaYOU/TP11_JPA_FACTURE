<html>
    <head>
        <meta charset="utf-8" />
        <title>liste des factures</title>
        <link type="text/css" rel="stylesheet" href="./css/style.css"  />
    </head>
    <body>

        <div>
			<table border CELLSPACING=0>
			<tr>
		      <th>Numéro facture</th>
		      <th>Nom Client</th>
		      <th>Prénom Client</th>
		      <th>Montant</th>
		    </tr>
				<#list monSetFacture as facture>	
					<tr ALIGN=center >	
						<td>${facture.idFacture}</td>
						<td>${facture.client.getNom()}</td>
						<td>${facture.client.getPrenom()}</td>
						<td>${facture.getTotalTTC()}</td>
					</tr>
				</#list>
			</table>
        </div>
    </body>
</html>