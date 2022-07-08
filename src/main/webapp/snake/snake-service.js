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

        let requestData = {
            color,
            head,
            tail
        }

        let fetchOptions = {
            method: "POST",
            body: JSON.stringify(requestData),
            headers: {"Content-type": "application/json"}
        }

        //TODO: update je slang aan de server-kant met de nieuwe gegevens
        return fetch("/restservices/snake", fetchOptions)
            .then(response => response.json())
    }
}
