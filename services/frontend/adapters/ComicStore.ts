/* eslint-disable @typescript-eslint/no-explicit-any */

import { ComicMetadata, ComicStore as ComicStorePort } from "services/ports/ComicStore";

export class ComicStore implements ComicStorePort {
    getAllTitles = async () => {
        const result = await fetch("http://localhost:8080/comics");
        const json = await result.json();
        return toMetadataList(json);
    };
    uploadComic = (data: FormData) => fetch("HTTP://localhost:8080/comics", { method: "POST", body: data });
}

function toMetadataList(json: any): [ComicMetadata] {
    return json.map((e: { id: any; title: any; }) => ({id: e.id, title: e.title}));
}

