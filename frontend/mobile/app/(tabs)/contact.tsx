import ListFriendComponent from "@/components/contact/ListFriendComponent";
import ListGroupComponent from "@/components/contact/ListGroupComponent";
import CustomSafeAreaView from "@/components/styles/CustomSafeAreaView";
import CustomSpacer from "@/components/styles/CustomSpacer";
import CustomSubTabMenu from "@/components/styles/CustomSubTabMenu";
import CustomTabMenu from "@/components/styles/CustomTabMenu";
import { useLanguage } from "@/hooks/useLanguage";
import { useState } from "react";
export default function TabContact() {
  const [menuSelected, setMenuSelected] = useState(0);
  const [subTabMenuSelected, setSubTabMenuSelected] = useState(0);

  const language = useLanguage();

  const menuName = [
    language.contact.tab_menu.friends,
    language.contact.tab_menu.groups,
  ];
  const subTabMenuName = [
    language.contact.sub_tab_menu.all,
    language.contact.sub_tab_menu.request,
  ];

  return (
    <CustomSafeAreaView
      styles={{
        padding: 0,
      }}
    >
      <CustomTabMenu
        menuName={menuName}
        menuSelected={menuSelected}
        setMenuSelected={setMenuSelected}
      />

      <CustomSpacer />

      <CustomSubTabMenu
        subTabMenuName={subTabMenuName}
        subTabMenuSelected={subTabMenuSelected}
        setSubTabMenuSelected={setSubTabMenuSelected}
      />
      
      <CustomSpacer />

      {
        menuSelected === 0 ? (
          <ListFriendComponent subTabMenuSelected={subTabMenuSelected} />
        ) : (
          <ListGroupComponent subTabMenuSelected={subTabMenuSelected} />
        )
      }
    </CustomSafeAreaView>
  );
}
