<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage de la facture supprimée</title>
        <link type="text/css" rel="stylesheet" href="./css/style.css"  />
    </head>
    <body>
    	<p>**********Affichage de la facture supprimée*************</p>
        <p>Date à mettre</p>
        <p>Client                     : ${facture.client.nom}</p>
        <p>Client                     : ${facture.client.prenom}</p>
        <p>AdresseLivraison client    : ${facture.client.adresse.getAdresseLivraison() }</p>
        <p>AdresseFacturation client  : ${facture.client.adresse.getAdresseFacturation()}</p>
        <p>Numéro de téléphone client : ${facture.client.telephone }</p>
        <p>Email client               : ${facture.client.email }</p>
        <div>
			<table border CELLSPACING=0>
			<tr>
		      <th>Article</th>
		      <th>Prix</th>
		      <th>Quantité</th>
		      <th>Total</th>
		    </tr>
				<#list facture.getLignes() as LigneArticle>	
					<tr ALIGN=center >	
						<td>${LigneArticle.getArticle().getNom()}</td>
						<td>${LigneArticle.getArticle().getPrix()}</td>
						<td>${LigneArticle.getQuantiteArticles()}</td>
						<td>${LigneArticle.getTotal()}</td>						
				</#list>
			</table>
		 <p>Total              :${facture.getTotalTTC()}</p>
		 <p>Paiement           :${facture.getStatus()}</p>
        </div>
    </body>
</html>