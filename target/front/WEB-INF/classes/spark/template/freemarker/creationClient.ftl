<html>
    <head>
        <meta charset="utf-8">
        <title>Menu gestion </title>
        <link type="text/css" rel="stylesheet" href="./css/style.css" />
    </head>
    <body>
        <div>
            <form method="post" action="/affichageClient">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="ageClient">Age </label>
                    <input type="text" id="ageClient" name="ageClient" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="adresseLivraisonClient">Adresse livraison<span class="requis">*</span></label>
                    <input type="text" id="adresseLivraisonClient" name="adresseLivraisonClient" value="" size="100" maxlength="100" />
                    <br />
                    
                    <label for="adresseFacturationClient">Adresse facturation<span class="requis">*</span></label>
                    <input type="text" id="adresseFacturationClient" name="adresseFacturationClient" value="" size="100" maxlength="100" />
                    <br />
    
                    <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
                    <input type="text" id="telephoneClient" name="telephoneClient" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="emailClient" value="" size="20" maxlength="60" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>