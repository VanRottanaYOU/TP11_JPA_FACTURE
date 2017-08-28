<html>
    <head>
        <meta charset="utf-8" />
        <title>Recherche utilisateur</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>

        <div>
            <form method="post" action="/affichageFacture">
                <fieldset>
                    <legend>Paiement de la facture</legend>
					<label for="idFacture">Email :<span class="requis">*</span></label>
                    <input type="text" id="idFacture" name="idFacture" value="" size="20" maxlength="20" />
                    <br />                                                             
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>