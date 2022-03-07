

export function uploadComic(formData) {
    return fetch("HTTP://localhost:8080/comics", { method: "POST", body: formData });
}

export function getAllTitles() {
    return fetch("http://localhost:8080/comics");

}