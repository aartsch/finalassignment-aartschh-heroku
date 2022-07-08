export default class GamesService {
    async getGameIds() {
        //TODO: fetch alle games van de de service, idealiter zonder alle details
        return fetch("/restservices/snake/game/")
            .then(response => response.json())
    }

    async getReplay(gameId) {
        //TODO: fetch de details van een enkele game. Let wel, het staat vrij wat voor informatie je precies toont
        //zolang je maar laat zien dat je data kunt opslaan over meerdere zetten heen. Dus deze dummy-data is puur
        //ter illustratie.
        let fetchOptions = {
            method: "GET",
            headers: {
                "Content-type": "application/json",
            }
        }
        return fetch("/restservices/snake/game" + gameId, fetchOptions)
            .then(response => response.json())
        }

    async removeReplay(gameId) {
        //TODO: gebruik fetch om een enkele game (bij de server) te deleten
        let fetchOptions = {
            method: "DELETE",
            headers: {
                "Content-type": "application/json",
            }
        }

        return fetch("/restservices/snake/game" + gameId, fetchOptions)
            .then(function (response) {
                if (response.ok) console.log("game deleted")
                else if (response.status == 404) console.log("game not found")
            })
    }
}
