export default class LoginService {
    isLoggedIn() {
        //TODO: hoe ga je bepalen of iemand ingelogd is (geweest)?
        return sessionStorage.getItem("JWT") != null;

    }

    login() {
        let formData = new FormData(document.querySelector("#loginForm"));
        let requestData = {
            username: formData.get("username"),
            password: formData.get("password")
        }

        let fetchOptions = {
            method: "POST",
            body: JSON.stringify(requestData),
            headers: {"Content-type": "application/json"}
        }

        return fetch("/restservices/login", fetchOptions)
            .then(function (response) {
                if (response.status !== 200) {
                    throw "Wrong credentials";
                } else {
                    return response.json();
                }
            })
            .then(function (myJson) {
                sessionStorage.setItem("JWT", myJson['JWT-token']);
                console.log("succesfull login")
            })
            .catch(function (error) {
                console.log("failed" + error);
            });
    }


    getUser() {
       /* let jwtToken = sessionStorage.getItem("JWT");

        let fetchOptions = {
            method: "POST",
            body: JSON.stringify(jwtToken),
            headers: {"Content-type": "application/json"}
        }

        return fetch("/restservices/user", fetchOptions)
            .then(function (response) {
                return response.status === 200;
            })*/
    }
        //TODO: deze GET method test je token op server-side problemen. Je kunt client-side op zich wel 'ingelogd' zijn
        //maar het zou altijd zomaar kunnen dat je token verlopen is, of dat er server-side iets anders aan de hand is.
        //Dus het is handig om te checken met een -echte fetch- of je login-token wel echt bruikbaar is.




    logout() {
        if(this.isLoggedIn()) {
            window.sessionStorage.clear();
            return Promise.resolve(window.sessionStorage.getItem("JWT") == null)
        }
        /*return Promise.resolve(null);*/

    }
}
