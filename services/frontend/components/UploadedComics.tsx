import Link from "next/link";
import React, { useEffect, useState } from "react";
import { ComicMetadata } from "services/ports/ComicStore";
import { comicStoreAdapter } from "../services/ComicStoreProvider";

export function UploadedComics(): JSX.Element {

    const [comicUiElements, setComicUiElements] = useState([<li key="loading">Loading...</li>]);

    useEffect(() => {
        comicStoreAdapter.getAllTitles().then(metadataResults => {
            setComicUiElements(
                metadataResults.map(toUi)
            );
        });
    }, []);

    return (
        <div>
            <h3>Uploaded Comics:</h3>
            <ul>{comicUiElements}</ul>
        </div>
    );
}
function toUi(metadata: ComicMetadata): JSX.Element {
    return <li key={metadata.id}>
        <Link href={"/view/" + metadata.id}>
            {metadata.title}
        </Link>
    </li>;
}