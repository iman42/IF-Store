import React, { useEffect, useState } from "react";

export function UploadedComics(): JSX.Element {

    const [comics, setComics] = useState("Loading...");

    useEffect(() => {
        fetch("http://localhost:8080/comics").then(result => {
            result.json().then(json => {
                setComics(json[0].title);
            });
        });
    }, []);

    return (
        <div>
            <span>Uploaded Comics:</span>
            <span>{comics}</span>
        </div>
    );
}
