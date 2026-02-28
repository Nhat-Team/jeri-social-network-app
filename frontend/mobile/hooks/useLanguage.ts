import { RootState } from "@/redux/store"
import { useSelector } from "react-redux"
import vietnamese from "@/assets/languages/vietnamese.json";
import english from "@/assets/languages/english.json";

export const useLanguage = () => {
    const language = useSelector((state: RootState) => state.language);

    if(language === "vietnamese") {
        return vietnamese;
    } else return english;
}