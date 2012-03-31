(ns website.views.index
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]
        [hiccup.page-helpers :only [include-css html5]]))
          
(defpartial link-item [{:keys [link title]}]
  [:li
    [:a {:href link :target "_blank"} title]])

(defpartial link-list [items]
  [:ul
    (map link-item items)])

(defpage "/" []
  (html5
    (include-css "/css/main.css")
    [:head
      [:title ":: 10ne.org ::"]]
    [:body
      [:div {:class "wrapper"}
        [:div {:id "titles"}
          [:h3 "Noam's"]
          [:h1 "10ne.org"]]
        [:div {:id "linkContainer"}


          (link-list [{:link "https://github.com/noamt"
                       :title "github"}
                      {:link "http://stackoverflow.com/users/198825/noamt"
                       :title "Stack Overflow"}
                      {:link "https://twitter.com/#!/NoamTenne"
                       :title "Twitter"}])]]]))
