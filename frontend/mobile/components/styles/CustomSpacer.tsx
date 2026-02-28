import { useAppTheme } from "@/hooks/useAppTheme";
import { View } from "react-native";

export default function CustomSpacer({ styles }:{ styles?: object }) {
    
    const theme = useAppTheme();
    
    return (
        <View style={[{
            height: 10,
            backgroundColor: theme.colors.backgroundSpacer
        }, styles]} />
    )
}