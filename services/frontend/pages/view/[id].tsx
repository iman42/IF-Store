import { useRouter } from "next/router";
import React from "react";

export default function View() {
    const router = useRouter();
    const id = router.query.id;

    return (
        <div>
            <object aria-label="comic-viewer" data={`http://localhost:8080/comics/${id}`} type="application/pdf" height="1200px" width="1200px" />
        </div>
    );
}
