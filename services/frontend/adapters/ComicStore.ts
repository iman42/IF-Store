/* eslint-disable @typescript-eslint/no-explicit-any */

import { ComicMetadata, ComicStore as ComicStorePort } from "services/ports/ComicStore";

export class ComicStore implements ComicStorePort {
    endpoint: string;
    constructor(url: string){
        this.endpoint = url + "/comics";
    }
    getAllTitles = async () => {
        const result = await fetch(this.endpoint);
        const json = await result.json();
        return toMetadataList(json);
    };
    uploadComic = (data: FormData) => fetch(this.endpoint, { method: "POST", body: data });
}

function toMetadataList(json: any): [ComicMetadata] {
    return json.map((e: { id: any; title: any; }) => ({id: e.id, title: e.title}));
}

