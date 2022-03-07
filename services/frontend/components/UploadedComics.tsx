import React, { useEffect, useState } from "react";
import { getAllTitles } from "../adapters/ComicStoreAPIInterface";

export function UploadedComics(): JSX.Element {

    const [comics, setComics] = useState([<li key="loading">Loading...</li>]);

    useEffect(() => {
        getAllTitles().then(result => {
            result.json().then(json => {
                setComics(
                    json.map(
                        (element: { id: string; title: string; }) => (
                            <li key={element.id}>{element.title}</li>
                        )
                    )
                );
            });
        });
    }, []);

    return (
        <div>
            <h3>Uploaded Comics:</h3>
            <ul>{comics}</ul>
        </div>
    );
}
