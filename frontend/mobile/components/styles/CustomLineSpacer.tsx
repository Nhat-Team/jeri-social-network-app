import { View } from "react-native"

export default function CustomLineSpacer({
    styles,
    props
}:{
    styles?: object,
    props?: object
}) {
    return (
        <View style={[{
            height: 1,
            backgroundColor: "#d4d4d4",
        }, styles]} {...props} />
    )
}