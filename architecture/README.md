```mermaid
graph TD
    subgraph frontend["Frontend (NextJS)"]
        browser["Browser (JavaScript)"] 
            --> cdn["CDN"] 
            --> next["NextJS Server"]
    end
    browser --> viewer["Viewer (Java)"]
    next --> comic_store["Comic Store (Java)"]
```