import React from "react";
import Collapsible from "./Collapsible";
import styles from "./SignInButtons.module.css";
export function SignInButtons() {

    return <div className={styles.something}>
        <div>
            <Collapsible open header="Login">
                Email
            </Collapsible>
        </div>
        <div>
            Signup
        </div>
    </div>;
}

