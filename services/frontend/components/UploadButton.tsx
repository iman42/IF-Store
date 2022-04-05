import Button from "@material-ui/core/Button";
import React from "react";
import { ComicStore as ComicStoreAdapter } from "../adapters/ComicStore";
import styles from "./UploadButton.module.css";

const UploadButton = (): JSX.Element => {
    const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const files = e.target.files;
        if (files && files[0]) {

            const sFileExtension = files[0].name.split(".")[files[0].name.split(".").length - 1].toLowerCase();
            const formData = new FormData();
            formData.append("file", files[0]);
            if (sFileExtension === "pdf")
                new ComicStoreAdapter().uploadComic(formData);
            else
                window.alert("THATS NO PDF!");
        }
    };

    return (
        <div className={styles.grid}>
            <input
                className={styles.hidden}
                id="upload-comic"
                type="file"
                onChange={onChange}
                name="file"
            />
            <label htmlFor="upload-comic">
                <Button variant="outlined" color="primary" component="span">
                    Upload Comic
                </Button>
            </label>
        </div>
    );
};

export default UploadButton;
