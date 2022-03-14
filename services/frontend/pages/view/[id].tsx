import { useRouter } from "next/router";
import React from "react";

export default function View() {
    const router = useRouter();
    const id = router.query.id;

    return (
        <div>
            {id}
        </div>
    );
}
