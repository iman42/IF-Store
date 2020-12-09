import Head from 'next/head'
import Hero from '../components/Hero'
import UploadButton from '../components/UploadButton'
import styles from '../styles/Home.module.css'

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
      </main>

      <footer className={styles.footer}>
        This is my footer.<br />
        There are many like it, but this one is mine.
      </footer>
    </div>
  )
}
