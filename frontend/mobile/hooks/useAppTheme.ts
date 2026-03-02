import { DarkTheme, LightTheme } from "@/constant/theme";
import { RootState } from "@/redux/store";
import { useSelector } from "react-redux";

export const useAppTheme = () => {
    const scheme = useSelector((state: RootState) => state.colorScheme);
    return scheme === 'light' ? DarkTheme : LightTheme;
}