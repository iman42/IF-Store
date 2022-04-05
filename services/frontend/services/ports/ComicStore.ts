export interface ComicMetadata{
    id: string
    title: string
}

export interface ComicStore{
    uploadComic: (data: FormData) => void;
    getAllTitles: () => Promise<[ComicMetadata]>;
}