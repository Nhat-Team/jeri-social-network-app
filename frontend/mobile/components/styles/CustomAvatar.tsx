import { useAppTheme } from "@/hooks/useAppTheme";
import { Image } from "react-native";

export default function CustomAvatar({ uri, styles, props }:{ uri: string, styles?: object, props?: object }) {
    
    const theme = useAppTheme();
    
    return (
        <Image source={{ uri: uri }} style={[{
            borderRadius: theme.borderRadius.full,
            borderWidth: 1,
            borderColor: theme.colors.borderColor,
        }, styles]} {...props}/>
    )
}