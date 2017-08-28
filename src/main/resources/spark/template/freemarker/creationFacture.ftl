<html>
    <head>
        <meta charset="utf-8">
        <title>Menu gestion </title>
        <link type="text/css" rel="stylesheet" href="./css/style.css" />
    </head>
    <body>
        <div>
            <form method="post" action="/affichageFacture">
                <fieldset>
                    <legend>Création facture</legend>
    
                    <label for="idClient">Numéro client <span class="requis">*</span></label>
                    <input type="text" id="idClient" name="idClient" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="idArticle">Numéro article </label>
                    <input type="text" id="idArticle" name="idArticle" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="quantiteArticle">Quantite Article </label>
                    <input type="text" id="quantiteArticle" name="quantiteArticle" value="" size="20" maxlength="20" />
                    <br />
                       
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>