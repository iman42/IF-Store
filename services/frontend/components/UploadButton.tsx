import Button from "@material-ui/core/Button";
import React from "react";
import styles from "./UploadButton.module.css";

const UploadButton = () : JSX.Element => (
    <div className={styles.grid}>
        <input 
            className={styles.hidden} 
            id="upload-comic" 
            type="file" 
            onChange={(e) => fetch("google.com")}
            name="file"></input>
        <label htmlFor='upload-comic'>
            <Button variant="outlined" color="primary" component="span">
                Upload Comic
            </Button>
        </label>
    </div>
);

export default UploadButton;