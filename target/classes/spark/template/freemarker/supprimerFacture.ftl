<html>
    <head>
        <meta charset="utf-8" />
        <title>Supprimer facture</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>

        <div>
            <form method="post" action="/suppressionFacture">
                <fieldset>
                    <legend>Suppression de la facture</legend>
					<label for="idFacture">Numéro facture :<span class="requis">*</span></label>
                    <input type="text" id="idFacture" name="idFacture" value="" size="20" maxlength="20" />
                    <br />                                                             
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>