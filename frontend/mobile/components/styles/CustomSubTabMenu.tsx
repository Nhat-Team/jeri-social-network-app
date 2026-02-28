import { useAppTheme } from "@/hooks/useAppTheme";
import { Pressable, Text, View } from "react-native";

export default function CustomSubTabMenu({
  subTabMenuName,
  subTabMenuSelected,
  setSubTabMenuSelected,
}: {
  subTabMenuName: string[];
  subTabMenuSelected: number;
  setSubTabMenuSelected: (index: number) => void;
}) {

  const theme = useAppTheme();

  return (
    <View
      style={{
        display: "flex",
        flexDirection: "row",
        alignItems: "center",
        justifyContent: "start",
        padding: 10,
      }}
    >
      {subTabMenuName.map((name, index) => {
        return (
          <Pressable key={index} onPress={() => setSubTabMenuSelected(index)} style={{
            backgroundColor: theme.colors.surface,
            borderRadius: theme.borderRadius.m,
            marginRight: theme.spacing.m,
          }}>
            <Text
              style={{
                textAlign: "center",
                color: theme.colors.textColor,
                fontSize: theme.typography.body.fontSize,
                fontWeight:
                  index === subTabMenuSelected
                    ? "bolder"
                    : theme.typography.body.fontWeight,
                padding: theme.spacing.s,
                width: 120,
              }}
            >
              {name}
            </Text>
          </Pressable>
        );
      })}
    </View>
  );
}
