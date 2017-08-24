<html>
    <head>
        <meta charset="utf-8" />
        <title>Menu gestion </title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="post" action="/modification">
                <fieldset>
                    <legend>Informations utilisateur</legend>
    
                    <label for="nomUtilisateur">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomUtilisateur" name="nomUtilisateur" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomUtilisateur">Prénom </label>
                    <input type="text" id="prenomUtilisateur" name="prenomUtilisateur" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="adresseUtilisateur">Adresse <span class="requis">*</span></label>
                    <input type="text" id="adresseUtilisateur" name="adresseUtilisateur" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="telephoneUtilisateur">Numéro de téléphone <span class="requis">*</span></label>
                    <input type="text" id="telephoneUtilisateur" name="telephoneUtilisateur" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="emailUtilisateur">Adresse email</label>
                    <input type="email" id="emailUtilisateur" name="emailUtilisateur" value="" size="20" maxlength="60" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>