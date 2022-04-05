import { ComicStore as ComicStorePort } from "services/ports/ComicStore";

export class ComicStore implements ComicStorePort {
    uploadComic = (data: FormData) => fetch("HTTP://localhost:8080/comics", { method: "POST", body: data });
}

export function getAllTitles() {
    return fetch("http://localhost:8080/comics");

}