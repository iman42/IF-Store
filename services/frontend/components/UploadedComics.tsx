import React, { useEffect, useState } from "react";

export function UploadedComics(): JSX.Element {

    const [comics, setComics] = useState([<li key="loading">Loading...</li>]);

    useEffect(() => {
        fetch("http://localhost:8080/comics").then(result => {
            result.json().then(json => {
                setComics(json.map((x: {id: string; title: string;}) => (<li key={x.id}>{x.title}</li>)));
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
