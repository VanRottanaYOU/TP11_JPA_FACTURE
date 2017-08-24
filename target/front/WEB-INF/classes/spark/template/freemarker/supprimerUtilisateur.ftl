<html>
    <head>
        <meta charset="utf-8" />
        <title>Suppression utilisateur</title>
        <link type="text/css" rel="stylesheet" href="./css/style.css"  />
    </head>
    <body>

        <div>
            <form method="post" action="/suppression">
                <fieldset>
                    <legend>Suppression de l'utilisateur</legend>
					<label for="emailUtilisateur">Code<span class="requis">*</span></label>
                    <input type="text" id="emailUtilisateur" name="emailUtilisateur" value="" size="20" maxlength="20" />
                    <br />                                                             
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>