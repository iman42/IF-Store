import Link from "next/link";
import React, { useEffect, useState } from "react";
import { comicStoreAdapter } from "../services/ComicStoreProvider";

export function UploadedComics(): JSX.Element {

    const [comics, setComics] = useState([<li key="loading">Loading...</li>]);

    useEffect(() => {
        comicStoreAdapter.getAllTitles().then(results => {
            setComics(
                results.map(
                    (element) => (
                        <li key={element.id}>
                            <Link href={"/view/" + element.id}>
                                {element.title}
                            </Link>
                        </li>
                    )
                )
            );
        });
    }, []);

    return (
        <div>
            <h3>Uploaded Comics:</h3>
            <ul>{comics}</ul>
        </div>
    );
}
