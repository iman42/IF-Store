import Head from "next/head";
import React from "react";
import Hero from "../components/Hero";
import UploadButton from "../components/UploadButton";
import { UploadedComics } from "../components/UploadedComics";
import styles from "../styles/Home.module.css";

export default function Home() {
    return (
        <div className={styles.container}>
            <Head>
                <title>IF Store</title>
                <link rel="icon" href="/favicon.ico" />
            </Head>

            <main className={styles.main}>
                <Hero />
                <UploadButton />
                <UploadedComics />
            </main>

            <footer className={styles.footer}>
                This is my footer.<br />
                There are many like it, but this one is mine.
            </footer>
        </div>
    );
}
