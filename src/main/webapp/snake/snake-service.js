export default class SnakeService {
    async getSnake() {
        //TODO: haal deze data van de server
        return fetch("/restservices/snake")
            .then(response => response.json())
    }

    async updateSnake(updatedSnake) {
        let color = updatedSnake.color
        let head = updatedSnake.head
        let tail = updatedSnake.tail

        let jsonRequestBody = {
            "color": color,
            "head": head,
            "tail": tail
        }

        let fetchOptions = {
            method: "PATCH",
            body: JSON.stringify(jsonRequestBody),
            headers: {"Content-type": "application/json"}
        }

        //TODO: update je slang aan de server-kant met de nieuwe gegevens
        return fetch("/restservices/snake", fetchOptions)
            .then(response => response.json())
            .then(function (myJson) {
                console.log(myJson)
            })
    }
}
