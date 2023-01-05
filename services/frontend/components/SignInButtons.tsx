import Collapsible from "./Collapsible";
import styles from "./SignInButtons.module.css";
export function SignInButtons() {

    return <div className={styles.something}>
        <div>
            <Collapsible header="Login">
                <div className="form">
                    <form>
                        <div className="input-container">
                            <label>Username </label>
                            <input type="text" name="uname" required />
                        </div>
                        <div className="input-container">
                            <label>Password </label>
                            <input type="password" name="pass" required />
                        </div>
                        <div className="button-container">
                            <input type="submit" />
                        </div>
                    </form>
                </div>
            </Collapsible>
        </div>
        <div>
            Signup
        </div>
    </div>;
}
