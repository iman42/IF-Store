import React, { useEffect, useState } from "react";

export function UploadedComics() {

    const [comics, setComics] = useState("Loading...");

    useEffect(() => {
        fetch("google.com").then(result => {
            result.text().then(text => {
                setComics(text);
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
