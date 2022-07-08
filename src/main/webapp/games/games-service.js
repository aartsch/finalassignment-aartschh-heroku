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
        return Promise.resolve({
            id: 'altijd-dezelfde',
            aantalBeurten: 42,
            meestBezochtePlek: { x: 3, y: 5},
            redenEind: 'muur-geraakt',
            aantalBochtjesLinksaf: 27
        });
    }

    async removeReplay(gameId) {
        //TODO: gebruik fetch om een enkele game (bij de server) te deleten
        let fetchOptions = {
            method: "DELETE",
            body: JSON.stringify(gameId),
            headers: {
                "Content-type": "application/json",
            }
        }

        return fetch("/restservices/snake/game", fetchOptions)
            .then(response => response.json())
    }
}
