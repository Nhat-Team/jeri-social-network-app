import dataGroup from "@/data/contact/list_group.json";
import Entypo from "@expo/vector-icons/Entypo";
import Ionicons from "@expo/vector-icons/Ionicons";
import { useEffect, useState } from "react";
import { Pressable, ScrollView, View } from "react-native";
import CustomAvatar from "../styles/CustomAvatar";
import CustomIcon from "../styles/CustomIcon";
import CustomSafeAreaView from "../styles/CustomSafeAreaView";
import CustomText from "../styles/CustomText";
import CustomTouchableOpacity from "../styles/CustomTouchableOpacity";

export default function ListGroupComponent({
  subTabMenuSelected,
}: {
  subTabMenuSelected: number;
}) {
  const [listGroups, setListGroups] = useState<object[]>([]);

  useEffect(() => {
    (async function getData() {
      return dataGroup;
    })().then((data) => setListGroups(data));
  });

  return subTabMenuSelected === 0 ? (
    <CustomSafeAreaView
      backgroundPriority="secondary"
      styles={{
        padding: 0,
      }}
    >
      <ScrollView>
        {listGroups
          .sort((a: any, b: any) => a.title.localeCompare(b.title))
          .map((group: object, index: number) => {
            return (
              <CustomTouchableOpacity
                backgroundPriority="secondary"
                key={index}
                styles={{
                  display: "flex",
                  flexDirection: "row",
                  justifyContent: "space-between",
                  alignItems: "center",
                  borderRadius: 0,
                  borderWidth: 1,
                  marginTop: 10,
                }}
              >
                <View
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <CustomAvatar
                    uri={group.avatar}
                    styles={{
                      width: 60,
                      height: 60,
                    }}
                  />
                  <CustomText
                    content={group.title}
                    styles={{
                      marginLeft: 10,
                    }}
                  />
                </View>

                <View
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <Pressable>
                    <CustomIcon icon={<Entypo name="log-out" size={30} />} />
                  </Pressable>

                  <Pressable
                    style={{
                      marginLeft: 20,
                      marginRight: 10,
                    }}
                  >
                    <CustomIcon
                      icon={
                        <Ionicons name="information-circle-outline" size={30} />
                      }
                    />
                  </Pressable>
                </View>
              </CustomTouchableOpacity>
            );
          })}
      </ScrollView>
    </CustomSafeAreaView>
  ) : (
    <CustomSafeAreaView></CustomSafeAreaView>
  );
}
