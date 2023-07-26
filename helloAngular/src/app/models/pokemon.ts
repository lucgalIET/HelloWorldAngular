// Definizione della classe Pokemon
export class Pokemon {
    // Proprietà della classe Pokemon
    id: number;         
    imgurl: string;     
    name: string;       
    imageLoaded: boolean;

    // Costruttore della classe Pokemon
    constructor(id: number, imgurl: string, name: string, imageLoaded: boolean) {
        this.id = id;
        this.imgurl = imgurl;
        this.name = name;
        this.imageLoaded = imageLoaded;
    }
}