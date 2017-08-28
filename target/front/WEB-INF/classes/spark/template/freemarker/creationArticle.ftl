<html>
    <head>
        <meta charset="utf-8">
        <title>Menu gestion </title>
        <link type="text/css" rel="stylesheet" href="./css/style.css" />
    </head>
    <body>
        <div>
            <form method="post" action="/affichageArticle">
                <fieldset>
                    <legend>Informations article</legend>
    				
                    <label for="nomArticle">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomArticle" name="nomArticle" value="" size="20" maxlength="20" />
                    <br />
                    <label for="prixArticle">Prix<span class="requis">*</span></label>
                    <input type="text" id="prixArticle" name="prixArticle" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="descriptionArticle">Description<span class="requis">*</span></label>
                    <input type="text" id="descriptionArticle" name="descriptionArticle" value="" size="20" maxlength="20" />
                    <br />
                                       
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>