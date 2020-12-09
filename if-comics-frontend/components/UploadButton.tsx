import styles from './UploadButton.module.css';

const UploadButton = () => (
    <div className={styles.grid}>
        <a href="https://nextjs.org/docs" className={styles.card}>
            <h3>Upload</h3>
            <p>Give us ya' masta' piece</p>
        </a>
    </div>
);

export default UploadButton;